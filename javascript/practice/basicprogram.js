function isPrime(number) {
    if (number <= 1) {
      return false;
    } 
    for (let i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return "is prime number";
  }
  
  // Test the function
//   const numberToCheck = 17; // Change this to any number you want to check
//   if (isPrime(numberToCheck)) {
//     console.log(numberToCheck + ' is a prime number.');
//   } else {
//     console.log(numberToCheck + ' is not a prime number.');
//   }
//========================================================================================
  function fibonacciSum(n) {
    if (n <= 0) {
      return 0;
    }
  
    let fibSeries = [0, 1];
    let sum = 1;
  
    for (let i = 2; i <= n; i++) {
      fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
      sum += fibSeries[i];
    }
  
    return sum;
  }
  
  // Test the function
  //const n = 10; // Replace 10 with any desired value of 'n'
//   const result = fibonacciSum(10);
//   console.log('The sum of the Fibonacci series',result);
//========================================================================================

function countEvenOddZero(arr) {
    let evenCount = 0;
    let oddCount = 0;
    let zeroCount = 0;
  
    for (let i = 0; i < arr.length; i++) {
      if (arr[i] === 0) {
        zeroCount++;
      } else if (arr[i] % 2 === 0) {
        evenCount++;
      } else {
        oddCount++;
      }
    }
  
    return {
      even: evenCount,
      odd: oddCount,
      zero: zeroCount
    };
  }
  
//   // Example usage:
//   const numbers = [2, 5, 0, 8, 3, 0, 10];
//   const result = countEvenOddZero(numbers);
//   console.log('Even count:', result.even);
//   console.log('Odd count:', result.odd);
//   console.log('Zero count:', result.zero);
  
  


  function functionGenerator(operate){
    switch(operate){
        case "isPrime":return[isPrime]
        case "fibonacciSum":return["fibo is ",fibonacciSum]
        case "countEvenOddZero":return["odd and even ",countEvenOddZero]
        default:return["invalid",null]
    }
}

// let answer= functionGenerator("isPrime")
// console.log(answer(19,20))
// console.log(answer(2))

let[messsage, checkPrime]=functionGenerator('isPrime') 
let x= checkPrime (2) 
console.log(x)

let[mess, checkFibo]=functionGenerator('fibonacciSum') 
let y= checkFibo (10) 
console.log(y)

let[checkcount]=functionGenerator('countEvenOddZero') 
let z= checkcount ([10,0,0,13,9,4,5,0])
console.log(z)