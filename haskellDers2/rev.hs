reverseList :: [a] -> [a]
reverseList [] = []
reverseList (x:xs) = reverseList xs ++ [x]

-- load rev.hs--
--reverseList[1,2]--

{-
x matches the first element of the input list
xs matches the rest of the list (everything except the first element)
x = 1, xs = [2,3]
It returns reverseList [2,3] ++ [1]
Then reverseList [2,3] returns reverseList [3] ++ [2]
Then reverseList [3] returns reverseList [] ++ [3]
reverseList [] returns [] (base case)
-}