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
<img src="/screenshot/insert_multiple.png">

### Queries
- Select all documents
<img src="/screenshot/find_all.png">

- Specify equality conditions
<img src="/screenshot/find_of.png">

- Specify conditions with query operators
<img src="/screenshot/find_of_multiple.png">

- Specify AND conditions
<img src="/screenshot/and.png">

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

### Total Price per Customer
- Input
<img src="/screenshot/mapReduce1.png">

- Output
<img src="/screenshot/mapReduceProof1.png">

### Order, Total Quantity and Average Quantity per Item
- Input
<img src="/screenshot/mapReduce2_1.png">
<img src="/screenshot/mapReduce2_2.png">

- Output
<img src="/screenshot/mapReduceProof2_1.png">
<img src="/screenshot/mapReduceProof2_2.png">

### Own Implementation
- My implementation is based off the previous MapReduce example and uses the same collection, 'orders'. However, there are some differences which proves why such operations prove useful for extracting and working with data.
- In the additional implementation, I want to find out how much money is spared in total for each product if given a certain discount. In this example, I used 20% discount for all products. 
- Input
<img src="/screenshot/mapReduce3_1.png">
<img src="/screenshot/mapReduce3_2.png">

- mapFunction3 iterates through the collection to assign key-value pairs, with sku (name of product) being the key, and an array consisting of quantity and price being the values.
- reduceFunction3 sets the value for quantity and price, then returns the new array reducedVal.
- finalizeFunction3 adds three new values of note: total, discount and saved. For each document, the total is calculated with its reducedVal's price and quantity, the discount is simply its reducedVal's price times 20% in decimalform (0.2), and saved is computated with its reducedVal's discount times quantity. Lastly, reducedVal is returned.
- Finally, db.orders.mapReduce() is called, which is done exactly the same as the previous example (with the exception of new functions and collection name).
- The result is the documents of the collection map_reduce_example3, that were created upon db.orders.mapReduce() if not made beforehand, otherwise it would be updated. The content of each document are assigned with key values (the _id's), being the names of the products, and the values, being the object consisting of the set values throughout the used functions, i.e. quantity, price, total, discount and saved.
- Such an implementation proves useful from a business standpoint to see which products customers spare more upon the larger the quantity with is, thus giving an impression of what products are more attractive to customers as well as what is more or less profitable with discounts. It also shows how similarly examples can be but still easily extract any kind of data and use it for sake of different purposes.
- Source for original functions: <a href="https://www.mongodb.com/docs/manual/tutorial/map-reduce-examples/#calculate-order-and-total-quantity-with-average-quantity-per-item">MongoDB, Calculate Order and Total Quantity with Average Quantity Per Item</a> (also seen from previous example).

- Output
<img src="/screenshot/mapReduceProof3_1.png">
<img src="/screenshot/mapReduceProof3_2.png">
<img src="/screenshot/mapReduceProof3_3.png">

## Pending issues
- None! :)
