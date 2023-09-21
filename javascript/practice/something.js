// var a=5
// var b
// b=10
// let c=15
// let d
// d=20
// console.log("a:",a)
// console.log("b:",b)
// console.log("c:",c)
// console.log("d:",d)

// const e=5
// const f=6
// console.log("e:",e)
// e=10
// console.log("e:",e)

// {
//     var a= 100
//     console.log("a:",a)
//     let c=150
//     console.log("c:",c)
//     d=200
//     console.log("d:",d)
// }
// console.log("a:",a)
// console.log("c:",c)
// console.log("d:",d)

// let a
// console.log("a:",a)
// let b=30
// console.log("b:",b,typeof b)
// let c= null
// console.log("c:",c,typeof c)
// let d= "rohit"
// console.log("d:",d,typeof d)
// let e=true
// console.log("c:",e,typeof e)

// ========reference typee array=======
// let a=[1,2,3,4]
// let b =[5,6,7,8]
// console.log(a[0])
// console.log(b[0])
// a=b
// a[0]=100
// console.log(a[0])
// console.log(b[0])

// let c=[1,2,3,4]
// let d=[1,2,3,4]
// c=d
// console.log(c==d)


// ===addition using switch case===
// function square(number) {
//     return number * number;
//   }

// function add(number1,number2) {
//   return number1 + number2;
// }

// function sub(number1,number2) {
//     return number1 - number2;
//   }

// function mygen(calculate){
//     switch(calculate){
//         case"add": return add
//         case "sub": return sub 
//         case "square": return square
   
//     }
// }

// // ====variadic function=====
// let operate= mygen("add")
// console.log(operate(19,20))
// console.log(operate(2))

// let add =(...numbers)=>{ 
//     sum=0 
//     for(i=0;i<numbers.length;i++){
//         sum += numbers[i]
//     } 
//     return sum
// } 
// console.log(add(1, 2, 3));  
// console.log(add(1, 2, 3, 4, 5));  
// console.log(add(10, 20, 30, 40, 50));



// const people = ['patrick', 'chimamanda', 'joe', 'sam']
// let reversedPeople = people.reverse()
// console.log(reversedPeople)
// console.log(people.includes('sam')) // true 
// console.log(people.includes('jack')) // false

// const lastPerson = people.pop()
// console.log(lastPerson) // "sam" 
// console.log(people) // ["patrick", "chimamanda", "joe"]

// const count = people.push('akilah', 'isaac')
// console.log(count) // 6 
// console.log(people) // ["patrick", "chimamanda", "joe", "sam", "akilah", "isaac"]

// const firstPerson = people.shift()
// console.log(firstPerson) // "patrick" 
// console.log(people) // ["chimamanda", "joe", "sam"]

// const count1 = people.unshift('akilah', 'isaac')
// console.log(count) // 6 
// console.log(people) // ["akilah", "isaac", "patrick", "chimamanda", "joe", "sam"]

// const numbers = ['one', 'two', 'four', 'five']
// numbers.splice(2, 0, "three")
// console.log(numbers) // ["one", "two", "three", "four", "five"]


//sort splice