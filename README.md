URL-Validator
=============
The program reads the urls from a text file named urls.txt that is in the
top level directory and performs the validation operation on them one by one.
I have made modification to the original design and this program 
is based on the modified version. The modified design document is also 
in the top level directory and is name URLValidationDesign. The unit test are 
covering all the different forms of urls that this program supports
the behavior of comparator and normalizer is undefined when passed invalid urls.
We are not comparing the invalid urls and therefore give no information back on 
whether our not the source and canonical form of the invalid url is 
unique or not since it does not make sense to compare them. 
we also don't create a canonical form for the invalid urls. the solution doesn't 
check the validation of query and fragment and also does not perform ping to validate the existence of each url. 
