import System.IO

-- Factorial using recursion (like a for loop)
factorial :: Integer -> Integer
factorial n = if n == 0 then 1 else n * factorial (n - 1)

main :: IO ()
main = do
    putStrLn "Enter a number: "
    hFlush stdout  -- Ensures prompt appears before input
    input <- getLine
    let num = read input :: Integer
    if num < 0 
        then putStrLn "Factorial is not defined for negative numbers!"
        else putStrLn ("Factorial of " ++ show num ++ " is " ++ show (factorial num))
