# CWE-787 Out-of-bounds Write
## What it is
At number 1 on the 2022 CWE Top 25 most dangerous software weaknesses is the Out-of-bounds Write. According to [cwe.mitre.org](https://cwe.mitre.org/data/definitions/787.html), "an out-of-bounds write occurs when the product writes data past the end, or before the beginning, of the intended buffer. This usually results in corruption of data, a crash, or code execution. The product may modify an index or perform pointer arithmetic that references a ememory location that is outside of the boundaries of the buffer. A subsequent write operation then produces undefined or unexpected results." This can be exploited by an attacker by allowing them to modify program execution flow. This is often pravalent in C and C++, whereas in a language like Java, buffer overflows cannot be performed on them. Instead, you would get an out of bounds exception, stopping your code from executing. 
## Examples
Here is an example of an out-of-bounds write in C:
```
int id_sequence[3];

/* Populate the id array. */

id_sequence[0] = 123;
id_sequence[1] = 234;
id_sequence[2] = 345;
id_sequence[3] = 456;
```
What's happening here is there is an array of integers whose size is defined by 3. However, while populating the array, it is being attempted to add more than 3 values to the 3 sized array, leading to an out-of-bounds write. This mistake could be made by someone who doesn't understand that in arrays, you start counting the values from placement 0, rather than placement 1. Therefore, `id_sequence[3]` is out of bounds.
*******
Here is an example of an out-of-bounds write in Java:
```
int[] list = {1, 2, 3};
for (int i = -1; i < list.length; i++) {
    list[i] = 4;
}
```
This one would be a little harder to do by mistake, but still produces an out-of-bounds write. `i`, which is set initially to -1, is being used as an index to add a number to the array. Since arrays start at index 0, trying to write to index -1 is impossible and out of bounds.
## Personal experience
My personal experience with it was quite frequently in CS-1180. It is quite a simple concept to understand that arrays start at index 0, rather than 1. However, it feels foreign at first and didn't stick with me. There were multiple times, just like in the examples, where I had tried to add to an array at an index that was out of bounds. When I would see an array with let's say a size of 5, I would have tried to add to the array from indexes 1-5, rather than 0-4. It was easy to notice because Java would let me know that I am getting an ArrayIndexOutofBoundsException. I got that exception a lot for out-of-bounds read as well, where I would try to retrieve a value from an index of an array that did not exist. All it took was shifting of numbers. Such a silly mistake, and luckily in my case it was always a simple fix and never lead to anything malicious happening. 