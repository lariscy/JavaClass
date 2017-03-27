package homework.proj9;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.27.2017
 * @dueDate 3.30.2017
 * @description RPSLS (Rock Paper Scissors Lizard Spock)
 */
public class RPSLSComputerPlayer extends RPSLSPlayer {
    
    // constants
    private static final String NAME_SUFFIX = " (computer)";
    private static final String[] NAMES = new String[]{
        "Bob", "Tom", "Sally", "Jim", "John", "Dallas", "Bella"
    };

    public RPSLSComputerPlayer() {
        super(NAMES[RPSLSGame.RANDOM.nextInt(NAMES.length)] + NAME_SUFFIX);
    }

    public RPSLSComputerPlayer(String name) {
        super(name + NAME_SUFFIX);
    }

    @Override
    public RPSLSOption shoot() {
        RPSLSOption[] options = RPSLSOption.values();
        return options[RPSLSGame.RANDOM.nextInt(options.length)];
    }
    
}
