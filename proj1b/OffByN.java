public class OffByN implements CharacterComparator{
    int offset;

    public OffByN(int n){
        offset = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == offset) || (y - x == offset);
    }
}
