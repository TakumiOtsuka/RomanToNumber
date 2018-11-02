#!/bin/bash
input=("I" "II" "III" "IIJ" "IV" "V" "VI" "VII" "VIII" "IX"
       "X" "XI" "XII" "XIII" "XIV" "XV" "XVI" "XIX"
       "XXIV" "XLII" "XLIX" "LXXXIX"
       "CCXCIX" "CDXCIII"
       "MCMLX" "MMXVIII" "MMMCMXCIX")
output=(1 2 3 0 4 5 6 7 8 9
        10 11 12 13 14 15 16 19
        24 42 49 89
        299 493
        1960 2018 3999)

javac Roman.java

end=`expr ${#input[@]} - 1`
for i in `seq 0 $end`
do
  ans=`java Roman ${input[$i]}`
  if [ "$ans" != "${output[$i]}" ]; then
    echo "error! ans=$ans out=${output[${i}]}"
  else
    echo "success!!"
  fi
done
