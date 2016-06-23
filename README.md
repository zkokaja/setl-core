# setl-core #

## Objective

A powerful, configurable, and efficient ETL tool.

## Design

The design for `setl` is straightforward. We break up the ETL into its constituents:
extract, transform, and load. Each of these is represented by an interface and are completely decoupled.

The entire process is handled by the `Engine`, which takes in a `Job` as its configuration. The process
begins with an `Extractor`, which is required to extract items from whatever source, and represent
them a list of `Record` objects.

A record is a flexible concept meant to represent a single extraction object. It's made up of properties which
have names. For example, a person has a property called 'age', with a value of '25'. Values can be arbitrary,
however, thus they are defined as `Field`s. A field can be a string, number, boolean, an array, or even a record.
This allows the representation of any object as defined by different extractors and loaders.

The engine takes each record and applies any number of transformations on it using a `Transformer`.
The transformer maps fields in the record to a `Transformation`. The transformation object implements the Composite
design pattern via the `CompositeTransformation` class, so to allow any number of transformations on one field.

When a record is done being transformed, it's ready for loading. A transformed record can be loaded into any number
of loaders. Thus, the engine maintains a map of each transformer to a list of `Loader` objects. A loader is simply
given a record, and it must load it into whatever source it represents.

An addition to this model, however, is a `Validator`, whose job is to validate the record from the extractor. The
validator is quite similar to a transformer. It has a number of `Validation` requirements mapped to specific fields, as
well as a `CompositeValidation` to apply multiple validations to a single field. This engine runs the validator after
it extracts a record and before it runs any transformations.

The engine compiles against on interfaces, thus any implementation can be injected for an extractor, 
loader, or transformations.

## Error Handling

Error handling is delegated by the engine to some `ErrorHandler` to allow for customized error handling. This handler
is given errors to handle at different stages of processing: validating, transforming, and loading. Each is designated
by its own exception (i.e. `ValidationException`, `LoaderException`). When an error is encountered, that record is
ignored.

An implementation of this is provided as a `LoaderErrorHandler` which uses a loader to write the errors somewhere. The
default is `stderr`, but since a loader is flexible, a different implementation can be easily injected.

## Command line Interface

A command line interface is available via the `com.kokaja.setl.Setl` class which accepts a file name parameter
that represents an XML file of a Spring bean schema. The only required bean is named `job` of type
`com.kokaja.setl.Job` as to be executed by the engine.

The test resources have examples of such XML configurations.

## TO-DO

* JDBC Extractor/Loader
* LDAP Extractor/Loader
