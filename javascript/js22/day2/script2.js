const ott=[
    {name:"netflix",price:1000,status:true,},
    {name:"amazonPrime",price:800,status:false,},
    {name:"voot",price:700, status:true, },
    { name:"Jiocinema", price:600,status:false,}
];
const userSubscriptions = ott.filter(ott => {
    return ott.status;
}); 

userSubscriptions.forEach(service => { 
    console.log(service.name); 
});
//=====================================================
const pricelist =[120,230,40,380,560]

const discountedprice = pricelist.map((price)=>{
    return price-price*0.2;
});

console.log(discountedprice);

//=======================================================
const products = [
    { id: 1, name: "Netflix", price: 1000 },
    { id: 2, name: "Amazon Prime", price: 800 },
    { id: 3, name: "Voot", price: 700 },
    { id: 4, name: "JioCinema", price: 400 }
];

for (const product of products) {
    // if (product.price > 500) {
    //     const discountedPrice = product.price * 0.7; // Apply 30% discount
    //     console.log("Product ID: " + product.id + ", Name: " + product.name + ", Original Price: " + product.price + ", Discounted Price: " + discountedPrice);
    // }
    const discountedPrice = product.price > 500 ? product.price * 0.7 : product.price;
    console.log("Product ID: " + product.id + ", Name: " + product.name + ", Price: " + discountedPrice);
}

const result = products.reduce((sum,product)=>{
    return product.price+sum;
},0);
console.log(result);

//===================================================================
var marklist=[5,6,3,93,60,1,10]
marklist.sort((a, b)=> a - b);

console.log(marklist.find(mark=>mark >80));
console.log(marklist);

ott.sort((p1,p2)=>{
    return p1.name.localeCompare(p2.name);
});

console.log(ott);