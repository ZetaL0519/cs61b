public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> wordInDeque= new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;

    }
    public boolean isPalindrome(Deque<Character> wordInDeque){
        while (wordInDeque.size() > 1) {
            return wordInDeque.removeFirst() == wordInDeque.removeLast() && isPalindrome(wordInDeque);
        }
        return true;
    }
    public boolean isPalindrome(String s){
        return isPalindrome(wordToDeque(s));
    }

    public boolean isPalindrome(Deque<Character> wordInDeque, CharacterComparator cc){
        while(wordInDeque.size()>1){
            return cc.equalChars(wordInDeque.removeFirst(), wordInDeque.removeLast()) && isPalindrome(wordInDeque, cc);
        }
        return true;
    }

    public boolean isPalindrome(String s, CharacterComparator cc){
        return isPalindrome(wordToDeque(s), cc);
    }
}
