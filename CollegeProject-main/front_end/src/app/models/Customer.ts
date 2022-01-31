export class Customer{
	id : Number
    fullName : String;
	mobileNumber: String;
    address: String;
	district: String;
	taluka: String;
	pincode: String;

}

export class CreateCustomer{
	fullName : String;
	mobileNumber: String;
    address: String;
	district: String;
	taluka: String;
	pincode: String;
}

export class Cart{
	productId : Number
	name : String
	quantity : Number
	perPeice : Number
	totalPrice : any
}
