// Step 1: Define the Command Interface
interface Command {
    void execute();
}

// Step 4: The TV class (Receiver)
class TV {
    public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }

    public void changeChannel(int channel) {
        System.out.println("Channel changed to " + channel);
    }

    public void adjustVolume(int volume) {
        System.out.println("Volume set to " + volume);
    }
}

// Step 2: Implement Concrete Command Classes
class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private TV tv;
    private int channel;

    public ChangeChannelCommand(TV tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}

class AdjustVolumeCommand implements Command {
    private TV tv;
    private int volume;

    public AdjustVolumeCommand(TV tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    @Override
    public void execute() {
        tv.adjustVolume(volume);
    }
}

// Step 3: The Invoker Class (RemoteControl)
class RemoteControl {
    private Command onCommand;
    private Command offCommand;

    public void setOnCommand(Command onCommand) {
        this.onCommand = onCommand;
    }

    public void setOffCommand(Command offCommand) {
        this.offCommand = offCommand;
    }

    public void pressOnButton() {
        if (onCommand != null) {
            onCommand.execute();
        }
    }

    public void pressOffButton() {
        if (offCommand != null) {
            offCommand.execute();
        }
    }
}

// Step 5: Putting Everything Together
public class CommandPatternApproach {
    public static void main(String[] args) {
        TV tv = new TV();

        // Create commands
        Command turnOn = new TurnOnCommand(tv);
        Command turnOff = new TurnOffCommand(tv);
        Command changeChannel = new ChangeChannelCommand(tv, 5);
        Command adjustVolume = new AdjustVolumeCommand(tv, 20);

        // Create remote control and assign commands
        RemoteControl remote = new RemoteControl();
        remote.setOnCommand(turnOn);
        remote.setOffCommand(turnOff);

        System.out.println("--- Command Pattern Approach Execution ---");
        remote.pressOnButton(); // Turn on the TV
        
        // Execute other standalone/queued commands
        changeChannel.execute(); 
        adjustVolume.execute(); 

        remote.pressOffButton(); // Turn off the TV
    }
}