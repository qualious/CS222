# Turkish Citizenship ID Number Verifier

Turkish Citizenship ID number is a unique number given to each
Turkish Citizen. This is an 11-digit number. The first 9 digits
of this number is it _base_, whereas the last two digits
are for _validation_.

For instance, Atatürk's ID number is 10000000146. Here, 100000001 is the _base_,
and 46 is the _validation _part.

In this assignment you will write a program that will read a 9-digit
number from the standard input.
Then, you will compute the 2-digit validation part,
and print a complete 11-digit number.

If the input is not a 9-digit number,
you will print an error message, and quit.

Here are sample runs, where the text in **bold** denotes text entered by the user.
Text in normal font is what is printed by your program.
 
<pre>
Enter a number: <b>783456</b>
Bad input. Bye.
</pre>

<pre>
Enter a number: <b>6573436783456</b>
Bad input. Bye.
</pre>

<pre>
Enter a number: <b>012345678</b>
Bad input. Bye.
</pre>

<pre>
Enter a number: <b>123456789</b>
Full ID number is 12345678950.
</pre>
 
<pre>
Enter a number: <b>100000001</b>
Full ID number is 10000000146.
</pre>

<pre>
Enter a number: <b>234567891</b>
Full ID number is 23456789138.
</pre>

## Algorithm to find the validation part from the base

Here is how the last two digits of the ID number is found
given the 9-digit base. As an example, suppose the base number
is 735196842.
 
1. Find the sum of the odd-indexed numbers, assuming that indexing
   starts from the left and the first index is 1. 
   This is 7+5+9+8+2 = 31.

2. Find the sum of the even-indexed numbers. 
   This is 3+1+6+4 = 14.
   
3. Multiply the number found in step 1 by 7.
   This gives 31 * 7 = 217.
   
4. Subtract the number found in step 2 from the number found in step 3.
   This gives 217-14 = 203.
   
5. Find the ones-digits (i.e. birler basamagi) of the number found in step 4.
   This gives 3. This is the first digit of the validation part.
   
6. Compute the sum of all the digits of the base plus the first validation digit.
   This gives 7+3+5+1+9+6+8+4+2+3 = 48.
   
7. Find the ones-digit of the number found in step 6.
   This gives 8. This is the second digit of the validation part.
   
So the validation part is 38,
and the full ID number is 73519684238.
