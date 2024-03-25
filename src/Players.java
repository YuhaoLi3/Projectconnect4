public class Players implements GamePiece {
    private String symbol;

    public Players(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
