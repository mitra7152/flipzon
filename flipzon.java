



package oopsjava;
import java.util.*;
import java.util.Map.Entry;
import java.lang.Math;
import java.lang.String;
interface productcategory{

void addCategoryID();
void addCategoryName();
String getNameCategory();


}
interface products {
void setProductId();
void setProductName();
void enterProductDetails();
void setPrice();
}
class Product implements productcategory,products{
Scanner sc=new Scanner(System.in);
public static HashMap <Integer,String> Categories=new HashMap<Integer,String>();
private int Categoryid;
private String CategoryName;
private String ProductName;
private float ProductID;
private String productdetails;
private float price;
protected int quantity;
public static HashMap <Float,String> pIN=new HashMap<Float,String>();//Id and name
public static HashMap <Float,String> pID=new HashMap<Float,String>();//Id and details
public static HashMap <Float,Float> pIP=new HashMap<Float,Float>();//Price with the Product id
public static HashMap <Float,Integer> pIQ=new HashMap<Float,Integer>();//Product id and quantity
public static HashMap <Float,Integer> pIC=new HashMap<Float,Integer>();//Product id and category id
public static HashMap <Float,Integer> pIPE=new HashMap<>();//id of the product and price for Elite Customers
public static HashMap <Float,Integer> pIPN=new HashMap<>();//normal 
public static HashMap <Float,Integer> pIPP=new HashMap<>();//prime

public void putcatprod() {
pIC.put(ProductID,Categoryid);//put the product id and value in the pIC hashmap


}
public void checkcategories() { //to check if the category already exists (to avoid having the same id)
System.out.println("Enter Category ID");
int xx=sc.nextInt();
boolean result=Categories.containsKey(xx);
if(result!=true) {
System.out.println("The category does not exist. Enter again");
checkcategories();
}
}
public int getCategoryId() {
return Categoryid;
}

@Override
public void addCategoryID() { //adding the category onto system
System.out.println("Add Category ID");
int ss=sc.nextInt();
this.Categoryid=ss;


}

public void removeProduct() { 
System.out.println("Enter the category id");
int xxxx=sc.nextInt();
System.out.println("Enter the product ID");
float xxyx=sc.nextFloat();
pIN.remove(xxyx);
pID.remove(xxyx);
pIP.remove(xxyx);
pIC.remove(xxyx);
if(counting.get(xxxx)==0) {
System.out.println("no product in a category, add a product. if you do not, the category will be deleted.");
String x1=sc.nextLine();
if(x1=="Add") {

checkcategories();
System.out.println("Add Product");
setProductId();
setProductName();
namesetting();
enterProductDetails();
putproductid();
putPorddets();
setPrice();
putprice();
setQuantity();
putiDquant();
putcatprod();

}
}
}
@Override
public String getNameCategory() {
// TODO Auto-generated method stub
return null;
}
public void setQuantity() { //setting the quantity
System.out.println("Enter the quantity");
int x=sc.nextInt();
this.quantity=x;
}
public void putiDquant() { //putting the id in the pIQ hashmap
pIQ.put(ProductID, quantity);
}
@Override
public void addCategoryName() {
System.out.println("Add Category Name");sc.next();

String ss=sc.nextLine();
this.CategoryName=ss;


}

public void catadd() {
String sy=sc.nextLine();
this.CategoryName=sy;
}
public void putCategories() {
Categories.put(Categoryid, CategoryName);
}

public int count=0;
public static HashMap<Integer, Integer> counting=new HashMap<>();
@Override
public void setProductId() {

System.out.println("Enter Product ID");
float x1=sc.nextFloat();

boolean result=pIN.containsKey(x1);
if(result==true) {
setProductId();
}
else {
this.ProductID=x1;
count++;
counting.put(this.Categoryid,count);
count=0;
}
}

public void removeCategory() {

}
@Override
public void setProductName() {
System.out.println("Product Name");
String sx=sc.nextLine();
this.ProductName=sx;

}
public void namesetting() {
String sy=sc.nextLine();
this.ProductName=sy;
}

public void putproductid() {

pIN.put(ProductID,ProductName);
}
@Override
public void enterProductDetails() {
System.out.println("Enter Product Specifications. DO NOT ENTER PRICE");
String sx=sc.nextLine();
this.productdetails=sx;

}
public void putPorddets() {
pID.put(ProductID, productdetails);
}
public void proddets() { //redundant
String sx=sc.nextLine();
this.productdetails=sx;

}

@Override
public void setPrice() {
System.out.println("Enter the price");
float sx=sc.nextFloat();
this.price=sx;

}
public void putprice() {
pIP.put(ProductID, price);
}
public void checkcatid() {
System.out.println("Enter Category id");
int x1=sc.nextInt();
boolean result=Categories.containsKey(x1);
if(result==true) {
System.out.println("Enter ID again. Already taken");
checkcatid();
}
else {
this.Categoryid=x1;
}
}
public void removecategories(Integer valueToBeRemoved) {
pIC.entrySet()
        .removeIf(
            entry -> (valueToBeRemoved.equals(entry.getValue())));

}
ArrayList<Float> keysss=new ArrayList<Float>();
//public void deleteprodbasedoncategory(Integer valueToBeRemoved) {
//for(Entry<Float, Integer> entry: pIC.entrySet()) {
//if(entry.getValue()==valueToBeRemoved) {
//keysss.add()
//}
//}
//}
}
class Admin extends Product{
private String userid;
protected float combinedPriceNormal;
protected float combinedpricePrime;
protected float combinedpriceElite;

Scanner sc=new Scanner(System.in);
private String username;
private String password;
public static HashMap <Integer,String> deals=new HashMap<Integer,String>();
public static HashMap <String,String> validCredentials =new HashMap<String,String>();
public static HashMap <String,String> usrstat=new HashMap<>();

public void putcredentials() {
validCredentials.put("Admin 1","Geeks");
validCredentials.put("Admin 2", "freaks");
validCredentials.put("a", "a");
}
public void setUsername() {
String user=sc.nextLine();
boolean result=validCredentials.containsKey(user);
if(result!=true) {
System.out.println("Inccorect Userid");
setUsername();
}
this.userid=user;
}
public void setPassword() {
String pass=sc.nextLine();
boolean result=validCredentials.containsValue(pass);
if(result!=true) {
System.out.println("Incorrect Password");
setPassword();
}
}
public String getUsername() {
return this.userid;
}
public static HashMap <Integer,Float> dealspriceE=new HashMap<>();
public static HashMap <Integer,Float> dealspriceP=new HashMap<>();
public static HashMap <Integer,Float> dealspriceN=new HashMap<>();
public static HashMap <Integer,String> dealswithprods=new HashMap<>();
public void combinedPrice() {
System.out.println("Dear Admin give the number of products you want to combine and giveaway a deal for");
int ghgaa=sc.nextInt();
float sum=0;
float xx3;
String xxxx=" ";
System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
for(int jjj=0;jjj<ghgaa;jjj++) {
System.out.println("Enter the ID of Product "+(jjj+1));
float xx1=sc.nextFloat();
xxxx=xxxx+ Float.toString(xx1)+" ";
//xx3=pIP.get(xx1);
//sum=sum+xx3;
}
System.out.println("Enter Unique ID for deal");
int xxxxx=sc.nextInt();
System.out.println("Enter the combined price(Should be less than their combined price) for Normal, Prime and Elite");
float ss3=sc.nextFloat();
float ss2=sc.nextFloat();
float ss1=sc.nextFloat();
this.combinedPriceNormal=ss1;
this.combinedpricePrime=ss2;
this.combinedpriceElite=ss3;

String str1="There is a deal on products with ID "+xxxx+" at price "+ss3 +" for Normal, at price "+ss2 +"for Prime and. at price "+ ss1 +" for Elite Customers";
deals.put(xxxxx,str1);
dealspriceE.put(xxxxx,ss1);
dealspriceN.put(xxxxx,ss3);
dealspriceP.put(xxxxx,ss2);
dealswithprods.put(xxxxx, xxxx);

}
Product p2=new Product();
ArrayList <Integer> elite=new ArrayList<Integer>();
ArrayList <Integer> prime=new ArrayList<Integer>();
ArrayList <Integer> normal=new ArrayList<Integer>();
public static HashMap <Float,Integer> Edisc=new HashMap<>();//to input if there is a discount on each of these categories
public static HashMap <Float,Integer> Pdisc=new HashMap<>();
public static HashMap <Float,Integer> Ndisc=new HashMap<>();
public void discountprod() {
System.out.println("Dear Admin give the Product ID you want to add discount for");
System.out.println("Enter the Product ID :");
float yxyx=sc.nextFloat();

System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms)");
int a1,a2,a3;
a1=sc.nextInt();
float yyy=pIP.get(yxyx);
float xxxx=yyy-(a1/100*yyy);
yyy=xxxx;
//pIPE.put(yyy, a1);
Edisc.put(yxyx, a1);
a2=sc.nextInt();
float yyyy=pIP.get(yxyx);
float xxx=yyyy-(a2/100*yyyy);
yyyy=xxx;
pIPP.put(yyyy, a2);
Pdisc.put(yxyx, a2);
a3=sc.nextInt();
float yyyyy=pIP.get(yxyx);
float xx=yyyyy-(a2/100*yyyyy);
yyyyy=xx;
pIPP.put(yyyy, a2);
Ndisc.put(yxyx, a3);
}
public float getCombinedEprice() {
return this.combinedpriceElite;
}
public float getCombinedPprice() {
return this.combinedpricePrime;
}
public float getCombinedNprice() {
return this.combinedPriceNormal;
}



}
class Customer extends Admin{
static Scanner sc=new Scanner(System.in);
public static HashMap <String,String> userCredentials=new HashMap <String,String>();
private String Username;
private String password;
private String Email;
private int Phonenumber;
private int Age;
private String userid;
private String Status="NORMAL";
private float balance=1000;
private float cost=0;
private float deliverycost=0;
private double discount=0;
private float totalcost=0;
public void setcreds() {

System.out.println("Enter name");sc.next();
String xs=sc.nextLine();
this.Username=xs;
System.out.println("Enter Password");
String xy=sc.nextLine();
this.password=xy;
userCredentials.put(xs,xy);

System.out.println("Enter Phone Number ");
int yy=sc.nextInt();//sc.next();
System.out.println("Enter Email ");
String xz=sc.next();
this.Email=xz;
System.out.println("Enter Age ");
int u=sc.nextInt();
this.Age=u;
this.Phonenumber=yy;
}
public void putstatus() {
usrstat.put(this.Username, this.Status);
}

public void checkuser() {
System.out.println("Enter name");sc.next();
String xs=sc.nextLine();
boolean result=userCredentials.containsKey(xs);
if(result==false) {
System.out.println("Incorrect Username. Enter Again");
checkuser();
}
this.userid=xs;
}
public String getUsername() {
return this.userid;
}
public void checkpassword() {
System.out.println("Enter password");
String xs=sc.nextLine();
boolean result=userCredentials.containsValue(xs);
if(result==false) {
System.out.println("Incorrect Pasword. Enter Again");
checkpassword();
}
}
public String getStatus() {
return this.Status;

}
public void setStatus() {
System.out.println("Choose new Status from Elite, Prime, Normal(ENTER IN CAPITAL LETTERS):");
System.out.println("CURRENT STATUS:"+getStatus());
String yyy=sc.next();
updateStatus(yyy);

putstatus();
}
public void setCurrentBalance() {
this.balance=1000;
}
public void updateStatus(String x) {
//System.out.println("Current Status:"+getStatus());
if(x.contentEquals("ELITE")==true) {
if(this.balance>=300) {
this.Status=x;
this.balance=this.balance-300;
System.out.println("Status updated to ELITE");
putstatus();
}
else {
System.out.println("Insufficient Balance");
}
}



if(x.contentEquals("PRIME")==true) {
if(this.balance>200) {
this.balance=this.balance-200;
this.Status=x;
System.out.println("Status updated to PRIME");
}
}


}
public float getBalance() {
return this.balance;
}
public double deliverycharges() {
double xx=0;
if(this.Status.contentEquals("NORMAL")) {
this.deliverycost+=100+(0.05*this.cost);
return this.deliverycost;
}
if(this.Status.contentEquals("ELITE")) {
this.deliverycost+=100;
return this.deliverycost;

}
else {
System.out.println(0.02*this.cost);
this.deliverycost+=100+(0.02*this.cost);
return this.deliverycost;
}
}

public void Delivery() {
if(this.Status.contentEquals("ELITE")) {
System.out.println("The delivery will be done within 2 days");
}
if(this.Status.contentEquals("PRIME")) {
System.out.println("The delivery will be made in 3-6 days");
}
if(this.Status.contentEquals("NORMAL")) {
System.out.println("The delivery will be done in 7-10 days");
}
}
private float cas;
public static HashMap <Float,Integer> buyingCart=new HashMap<>();
public void addtocart() {
System.out.println("Enter Product ID and Quantity");
float xxx=sc.nextFloat();
this.cas=xxx;
int x=sc.nextInt();

if(x<=pIQ.get(xxx)) {
System.out.println("Item Successfully added to cart");
buyingCart.put(xxx, x);


}
else {
System.out.println("There is not enough stock of product "+xxx);
}

}
public void updateQuantity(float xxx,int x) {
this.quantity=this.quantity-x;
pIQ.put(xxx, this.quantity);
}
public void checkoutcart() {
float xxx=0;
float x=0;
if(buyingCart.size()!=0) {
for(float key : buyingCart.keySet()) {
x=x+key;
xxx=pIP.get(key);
this.cost+=xxx*buyingCart.get(key);

}

if(this.cost>this.balance) {
System.out.println("Insufficient Balance");
this.cost=0;
}
else {
System.out.println("Your order is placed successfully. Details:");
System.out.println("Product Name:"+pIN.get(x));
System.out.println("Product ID"+x);
System.out.println("Product Details:" +pID.get(x));
System.out.println("Price:"+pIP.get(x));
System.out.println("Quantity:"+buyingCart.get(x));
System.out.println("DeliveryCharges:"+deliverycharges());
discount();
System.out.println("Total Cost="+generateTotalCost());
this.balance=this.balance-this.totalcost;
Delivery();
generateCoupons();
displayCoupons();
this.totalcost=0;
this.cost=0;
this.deliverycost=0;
//this.Status="NORMAL";
emptyCart();

}
}
if(dealtocart.size()!=0) {
System.out.println(this.value);
dealcheckout(this.value);
displayCoupons();
dealtocart.clear();
}
}
public void emptyCart() {
buyingCart.clear();
}
public float generateTotalCost() {
this.totalcost=(float) (getCost()+getDeliverCharges()-this.discount);
return this.totalcost;
}
public float getDeliverCharges() {
return this.deliverycost;
}
public float getCost() {
return this.cost;
}
public double getDiscout() {
return this.discount;
}
public void discount() {
if(this.Status.contentEquals("ELITE")==true) {
float elitediscount=(float)0.1;
float hh=0;
try {
if(Edisc.size()!=0 && Edisc.containsKey(this.cas)==true) {
float bb=Edisc.get(this.cas);
hh=hh+bb/100;
}
}
catch(NullPointerException e) {


}
float aaaa=elimaxdiscoun/100;
float yyy=getCost();
float xxs=max(elitediscount,hh,aaaa);
this.discount=(yyy*(xxs));
System.out.println("Discount="+(yyy*(xxs)));
//this.discount=xxx;
}
if(this.Status.contentEquals("PRIME")==true) {

float primediscount=(float)0.05;

float gg=0;

if(Pdisc.size()!=0 && Pdisc.containsKey(this.cas)==true) {
float bb=Pdisc.get(this.cas);
gg=gg+bb/100;
}


float aaaa=primaxdiscoun/100;

float yyy1=getCost();

float xxs=max(primediscount,gg,aaaa);

this.discount=(yyy1*(xxs));
//sthis.discount=(yyy1*(0.05));
System.out.println("Discount="+(yyy1*(0.05)));
}
if(this.Status.contentEquals("NORMAL")==true) {

float kk=0;
if(Pdisc.size()!=0 && Edisc.containsKey(this.cas)==true) {
float bb=Pdisc.get(cas);
kk=bb/100;
}
if(kk>0) {
this.discount=kk;
System.out.println("Discount="+kk);
} 
else{
System.out.println("Discount="+0);
}
}
//return this.discount;
}
private float max(float a, float b, float c) {

if(a>b && a>c) {
return a;
}
if(b>c) {
return b;
}
else {
return c;
}
}
public void addAmount() {
System.out.println("Enter amount to add");
float xxx=sc.nextFloat();
this.balance+=xxx;
}
public void browseProducts() {
System.out.println(pIN);
System.out.println(pID);
System.out.println(pIP);

}
public void browseDeals() {
System.out.println(deals);
}
public int value;
public float dealcost=0;
public float totaldealcost;
public static HashMap <Float,String> dealtocart=new HashMap<>();
public void addproductsindeal() {
System.out.println("Enter the Deal Id");
float xxxx=sc.nextInt();
this.value=(int)xxxx;
String xx=dealswithprods.get(xxxx);
dealtocart.put( xxxx, xx);

System.out.println("Item successsfully added");
}
public void setdealcost(float x) {
this.dealcost=this.dealcost+x;
}
public float getdealcost(){
return this.dealcost;
}

@SuppressWarnings("unlikely-arg-type")
private void dealcheckout(float xxxx) {

if(this.Status.contentEquals("ELITE")) {

System.out.println(dealcost);
//System.out.println(combinedpriceElite);
if((dealspriceN.get(this.value)+(100+(dealspriceN.get(this.value))))<=this.balance) {
float yy=dealspriceE.get(this.value);
System.out.println("The Product IDs are "+dealswithprods.get(this.value));
System.out.println("The Price is "+ dealspriceE.get(this.value));
System.out.println("The Delivery Charge is "+100);
System.out.println("The Delivery will be done within 2 Days");
this.totalcost=100+dealspriceE.get(this.value);
System.out.println("The total cost is "+this.totalcost);
}
else {
System.out.println("Insufficient Balance");
}

}
if(this.Status.contentEquals("NORMAL")) {
this.dealcost=getdealcost()+getCombinedNprice();
if((dealspriceN.get(this.value)+(100+(0.05*dealspriceN.get(this.value))))<=this.balance)  {
System.out.println("The Product IDs are "+dealswithprods.get(this.value));
System.out.println("The Price is "+ dealspriceN.get(this.value));
System.out.println("The Delivery Charge is "+100);
System.out.println("The Delivery will be done within 6 Days");
this.totalcost=(float) (dealspriceN.get(this.value)+(100+(0.05*dealspriceN.get(this.value))));
System.out.println("The total cost is "+this.totalcost);
}
else {
System.out.println("Insufficient Balance");
}

}
if(this.Status.contentEquals("PRIME")) {
this.dealcost=getdealcost()+getCombinedPprice();;
if((dealspriceN.get(this.value)+(100+(0.02*dealspriceN.get(this.value))))<=this.balance) {
System.out.println("The Product IDs are "+dealswithprods.get(this.value));
System.out.println("The Price is "+ dealspriceN.get(this.value));
System.out.println("The Delivery Charge is "+100);
System.out.println("The Delivery will be done within 2 Days");
this.totalcost=(float) (dealspriceP.get(this.value)+(100+(0.02*dealspriceP.get(this.value))));
System.out.println("The total cost is "+this.totalcost);
}
else {
System.out.println("Insufficient Balance");
}
}
this.dealcost=(float) 0;
this.totalcost=0;
//this.balance=1000;
//this.balance=1000;
this.Status="NORMAL";

}

public void totaldealcost() {
}
public void viewcart() {
if(buyingCart.size()!=0) {
System.out.println(buyingCart);
}
if(dealswithprods.size()!=0) {
System.out.println(dealswithprods);
}
}
public static HashMap <Integer,Integer> couponsdis=new HashMap<>();
public float elimaxdiscoun=0;
public float primaxdiscoun=0;
public void generateCoupons() {
if(this.Status.contentEquals("ELITE") && this.cost>5000) {
for(int i=1;i<3;i++) {
int x=15;
couponsdis.put(i, x);
}
for(int j=3;j<5;j++) {
int y=15;
couponsdis.put(j, y);
System.out.println("Thesse are your coupns:"+couponsdis);
}
elimaxdiscoun=15;
}
if(this.Status.contentEquals("PRIME") && this.cost>5000) {
for(int i=1;i<2;i++) {
int x=15;
couponsdis.put(i, x);
}
for(int j=2;j<3;j++) {
int y=15;
couponsdis.put(j, y);
}
System.out.println("Thesse are your coupns:"+couponsdis);
primaxdiscoun=15;
}
if(this.Status.contentEquals("NORMAL") ) {
System.out.println("You have no Coupons");
}
if(couponsdis.size()==0){
System.out.println("You have no Coupons");
}
}
public void displayCoupons() {
//System.out.print(couponsdis);
}
}
class flipzon{
public static void mainmenu() {
System.out.println("WELCOME TO FLIPZON\r\n"
+ "1) Enter as Admin\r\n"
+ "2) Explore the Product Catalog\r\n"
+ "3) Show Available Deals\r\n"
+ "4) Enter as Customer\r\n"
+ "5) Exit the Application");
}
public static void  adminmenu() {
System.out.println("Please choose any one of the following actions:\r\n"
+ "1) Add category\r\n"
+ "2) Delete category\r\n"
+ "3) Add Product\r\n"
+ "4) Delete Product\r\n"
+ "5) Set Discount on Product\r\n"
+ "6) Add giveaway deal\r\n"
+ "7) Back");
}
public static void customermenu1() {
System.out.println("1) Sign up\r\n"
+ "2) Log in\r\n"
+ "3) Back");
}
public static void customermenu2() {
System.out.println("1) browse products\r\n"
+ "2) browse deals\r\n"
+ "3) add a product to cart\r\n"
+ "4) add products in deal to cart\r\n"
+ "5) view coupons\r\n"
+ "6) check account balance\r\n"
+ "7) view cart\r\n"
+ "8) empty cart\r\n"
+ "9) checkout cart\r\n"
+ "10) upgrade customer status\r\n"
+ "11) Add amount to wallet\r\n"
+ "12) back");
}
static Admin a1=new Admin();
static Customer c1=new Customer();
static Product p11=new Product();
@SuppressWarnings("static-access")
public static void main(String []args) {
Scanner sc=new Scanner(System.in);
boolean checkmenu=true;
mainmenu();
while(checkmenu==true) {
int mainmenuselector=sc.nextInt();
if(mainmenuselector==1) {
System.out.println("Dear Admin,\r\n"
+ "Please enter your username and password");
a1.putcredentials();
a1.setUsername();
a1.setPassword();
System.out.println("Welcome "+a1.getUsername()+"!!!!");
adminmenu();
int sa=sc.nextInt();
while(true) {
if(sa==1) {
p11.addCategoryName();
p11.checkcatid();
p11.putCategories();
System.out.println("Add Product");
p11.setProductId();
p11.setProductName();
p11.namesetting();
p11.enterProductDetails();
p11.putproductid();
p11.putPorddets();
p11.setPrice();
p11.putprice();
p11.setQuantity();
p11.putiDquant();
p11.putcatprod();

adminmenu();
sa=sc.nextInt();
}
if(sa==2) {
System.out.println("Enter the Category Id");
int ysy=sc.nextInt();
p11.removecategories(ysy);
adminmenu();
sa=sc.nextInt();

}
if(sa==3) {

p11.checkcategories();
System.out.println("Add Product");
p11.setProductId();
p11.setProductName();
p11.namesetting();
p11.enterProductDetails();
p11.putproductid();
p11.putPorddets();
p11.setPrice();
p11.putprice();
p11.setQuantity();
p11.putiDquant();
p11.putcatprod();

adminmenu();
sa=sc.nextInt();


}
if(sa==4) {
p11.removeProduct();
adminmenu();
sa=sc.nextInt();


}
if(sa==6) {
a1.combinedPrice();
adminmenu();
sa=sc.nextInt();
}
if(sa==5) {
a1.discountprod();
adminmenu();
sa=sc.nextInt();
}
if(sa==7) {
mainmenu();
break;
}

}
}
if(mainmenuselector==2) {
while(true) {
if(p11.pIN.size()==0) {
System.out.println("There are no Products");
}
else {
System.out.print(Product.pIN+"\n");
}
mainmenu();
break;
}
}
if(mainmenuselector==3) {
while(true) {
if(a1.deals.size()==0) {
System.out.println("Dear User, there are no deals for now!!! Please check regularly for exciting deals.");
}
else {
System.out.print(a1.deals+"\n");
}
mainmenu();
break;
}
}
if(mainmenuselector==4) {
while(true) {
customermenu1();
int xyxy=sc.nextInt();
if(xyxy==1) {
c1.setcreds();
}
if(xyxy==2) {
c1.checkuser();
c1.checkpassword();
System.out.println("Welcome " + c1.getUsername() +" to FLipzon");
customermenu2();
while(true) {
int xxx=sc.nextInt();
if(xxx==10) {
c1.setStatus();;

customermenu2();
//xxx=sc.nextInt();
}
if(xxx==6) {
System.out.println("Current Account Balance is "+c1.getBalance());
customermenu2();
//xxx=sc.nextInt();
}
if(xxx==3) {
c1.addtocart();
customermenu2();
//xxx=sc.nextInt();
}
if(xxx==9) {
c1.checkoutcart();
customermenu2();
//xxx=sc.nextInt();
}
if(xxx==11) {
c1.addAmount();
customermenu2();
//xxx=sc.nextInt();
}
if(xxx==8) {
c1.emptyCart();
System.out.println("Cart Emptied Successfully");
customermenu2();
//xxx=sc.nextInt();
}
if(xxx==1) {
c1.browseProducts();
customermenu2();
//xxx=sc.nextInt();
}
if(xxx==2) {
c1.browseDeals();
customermenu2();
//xxx=sc.nextInt();
}
if(xxx==4) {
c1.addproductsindeal();
customermenu2();
//xxx=sc.nextInt();

}
if(xxx==7) {
c1.viewcart();
customermenu2();
///xxx=sc.nextInt();

}
if(xxx==5) {
c1.generateCoupons();
c1.displayCoupons();
customermenu2();
///xxx=sc.nextInt();

}
if(xxx==12) {
c1.setCurrentBalance();
break;
}

}
}
if(xyxy==3) {
mainmenu();
break;

}
}
}
}
}

}