URL-Validator
=============
We are not comparing the invalid urls and therefore give no information back on whether our not the source and
canonical form of the invalid url is unique or not since it does not make sense to compare them. we also don't
create a canonical form for the invalid urls. the solution doesn't check the validation of query and fragment
and also does not perform ping to validate the existence of each url. 
cse403