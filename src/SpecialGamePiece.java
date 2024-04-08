public class SpecialGamePiece extends GamePiece {
    public SpecialGamePiece(String symbol) {
        super(symbol + "*");
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}