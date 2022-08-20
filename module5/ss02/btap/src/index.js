"use strict";
exports.__esModule = true;
// function tra ve cac so fibonacci dau tien
function fibonacci(count) {
    var a = 1;
    var b = 1;
    var c;
    var array = [];
    array.push(a);
    array.push(b);
    for (var i = 2; i < count; i++) {
        c = a + b;
        array.push(c);
        a = b;
        b = c;
    }
    return array;
}
var sum = 0;
var array = fibonacci(10);
for (var i = 0; i < array.length; i++) {
    sum += array[i];
}
console.log("Cac so fibonacci la " + array);
console.log("tong cua 10 so fibonacci dau tien la " + sum);
// Su dung de quy
function fibonacci1(n) {
    if (n == 1 || n == 2)
        return 1;
    return fibonacci1(n - 1) + fibonacci1(n - 2);
}
var sum2 = 0;
for (var i = 1; i <= 10; i++) {
    sum2 += fibonacci1(i);
    console.log(fibonacci1(i));
}
console.log("Tong cac so fibonacci la" + sum2);
