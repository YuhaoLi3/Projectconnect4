import java.util.ArrayList;
import java.util.List;

public class SymbolManager {
    private List<String> availableSymbols;

    public SymbolManager() {
        availableSymbols = new ArrayList<>();
        Symbols();
    }
    private void Symbols() {
        availableSymbols.add("🙂");
        availableSymbols.add("🌹");
        availableSymbols.add("📚");
        availableSymbols.add("⚽");
        availableSymbols.add("🌞");
        availableSymbols.add("🪐");
        availableSymbols.add("🌌");
        availableSymbols.add("🧭");
        availableSymbols.add("🛸");
        availableSymbols.add("🦩");
        availableSymbols.add("🪴");
        availableSymbols.add("🛖");
        availableSymbols.add("🪵");
        availableSymbols.add("🧊");
        availableSymbols.add("🪶");
    }
    public void displayAvailableSymbols() {
        System.out.println("Available symbols:");
        for (int i = 0; i < availableSymbols.size(); i++) {
            System.out.println(i + ": " + availableSymbols.get(i));
        }
    }
    public String chooseSymbol(int index) {
        if (index >= 0 && index < availableSymbols.size()) {
            return availableSymbols.remove(index);
        } else {
            System.out.println("Invalid selection. Please choose a valid symbol.");
            return null;
        }
    }
}




