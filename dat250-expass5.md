### DAT250 Expass 5

## Technical issues
- I encountered an issue related to receiving False first as a result from package validation, although it was due to package version differences. Fixed it by changing the expected version.
- I encountered an issue with the usage of mapReduce on a database with mongosh. Found out it was due to using the local database, which I was not supposed to do for mapReduce.

## Installation Package Validation
- Note: I installed two different packages, the former being v.8.0.0 and the latter v.7.4.1.
<img src="/screenshot/installation_package_validation_v8.png">
<img src="/screenshot/installation_package_validation_v7.png">

## Experiment 1

### Inserts
- Single document
<img src="/screenshot/insert_one.png">

- Multiple documents
<img src="/screenshot/insert_mutiple.png">

### Queries
- Select all documents
<img src="/screenshot/find_all.png">

- Specify equality conditions
<img src="/screenshot/find_of.png">

- Specify conditions with query operators
<img src="/screenshot/find_of_multiple.png">

- Specify AND conditions
<img src="/screenshot/and.npg">

- Specify OR conditions
<img src="/screenshot/or.png">

- Specify AND + OR conditions
<img src="/screenshot/and_or.png">

### Updates
- Update single document
<img src="/screenshot/update_single_doc.png">

- Update multiple documents
<img src="/screenshot/update_multiple_docs.png">

- Replace single document
<img src="/screenshot/replace_doc.png">

### Deletes
- Delete all documents
<img src="/screenshot/del_docs.png">

- Delete all documents with a certain condition
<img src="/screenshot/del_spec_docs.png">

- Delete single document with a certain condition 
<img src="/screenshot/del_spec_doc.png">

### Bulk-Writes
- Input
<img src="/screenshot/bulkWrite_input.png">

- Output
<img src="/screenshot/bulkWrite_output.png">

## Experiment 2
<img src="/screenshot/">

## Pending issues
- None! :)
