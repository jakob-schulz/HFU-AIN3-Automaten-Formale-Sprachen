public class WortImpl implements Wort {
    private final String word;

    WortImpl(String s){
        word = s;
    }

    @Override
    public char position(int k) {
        return word.charAt(k-1);
    }

    @Override
    public int laenge() {
        return word.length();
    }

    @Override
    public Wort concat(Wort w) {
        if(w instanceof WortImpl){
            return new WortImpl(word + ((WortImpl) w).word);
        }
        return new WortImpl(word);
    }

    @Override
    public int anzahl(char c) {
        int count = 0;
        for(int position = 0; position < word.length(); position++){
            if(word.charAt(position) == c){
                count++;
            }
        }
        return count;
    }

    @Override
    public Wort tausche(char c1, char c2) {
        return new WortImpl(word.replace(c1, c2));
    }

    @Override
    public int istTeilwortVon(Wort w) {
        if(w instanceof WortImpl){
            return word.indexOf(((WortImpl)w).word) + 1;
        }
        return 0;
    }

    @Override
    public Wort teilwort(int start, int laenge) {
        return new WortImpl(word.substring(start-1, start + laenge - 1));
    }

    @Override
    public Wort ersetze(Wort w1, Wort w2) {
        if(w1 instanceof WortImpl){
            return new WortImpl(word.replaceAll(((WortImpl) w1).word, ((WortImpl) w2).word));
        }
        return null;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof WortImpl)
        {
            return word.equals(((WortImpl) obj).word);
        }
        return false;
    }
}
