// happy coding 👻
console.log("hello world");

function isPrime(num:number) : boolean {
    let isPrime=true;
    if (num<2){
        isPrime=false;
    }else if (num>2) {
        for (let i=2; i<=Math.sqrt(num);i++){
            if (num%i==0){
                isPrime=false;
                break;
            }
        }
    }


    return isPrime;

}

let array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
let sum = 0;

for (let number of array){
    if (isPrime(number)){
        sum+=number;
    }
}
console.log("Tổng các số nguyên tố trong mảng trên là: " + sum);