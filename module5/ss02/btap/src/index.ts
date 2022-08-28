// happy coding 👻
import {finished} from "stream";
// function tra ve cac so fibonacci dau tien
function  findNumFibonacci(count:number) {
    let number1:number =1;
    let number2:number =1;
    let number3:number;
    let array:Array<number>=[];
    array.push(number1);
    array.push(number2);
    for (let i:number=2;i<count;i++){
        number3=number1+number2;
        array.push(number3);
        number1=number2;
        number2=number3;
    }
    return array;
}


let sum:number=0;
let array:Array<number> = findNumFibonacci(10);
for (let i:number=0;i<array.length;i++){
    sum += array[i];
}
console.log("Cac so fibonacci la " +array);
console.log("tong cua 10 so fibonacci dau tien la " +sum);



// Su dung de quy
function findNumFibonacciByRecursive(num:number):number{
    if (num == 1 || num == 2) return 1;
    return findNumFibonacciByRecursive(num-1) + findNumFibonacciByRecursive(num-2);
}
let sum2:number=0;
for (let index : number=1;index<=10;index++){
    sum2+=findNumFibonacciByRecursive(index);
    console.log(findNumFibonacciByRecursive(index));
}
console.log("Tong cac so fibonacci la" +sum2)
