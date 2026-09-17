// The TV Receiver class
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

// The Remote Control (Invoker) - Traditional approach with constructor accepting TV
class RemoteControl {
    private TV tv;

    // Explicitly defining the constructor that accepts a TV object
    public RemoteControl(TV tv) { 
        this.tv = tv; 
    }

    public void pressOnButton() { 
        tv.turnOn(); 
    }

    public void pressOffButton() { 
        tv.turnOff(); 
    }

    public void pressChannelButton(int channel) { 
        tv.changeChannel(channel); 
    }

    public void pressVolumeButton(int volume) { 
        tv.adjustVolume(volume); 
    }

    // Handles multiple actions (the messy/ugly code approach)
    public void pressOnChangeVolumeAndChannelButton(int volume, int channel) {
        tv.turnOn();
        tv.changeChannel(channel);
        tv.adjustVolume(volume);
    }
}

// Main class to run the traditional implementation
public class CommandPatternTrad {
    public static void main(String[] args) {
        TV tv = new TV();
        
        // This will now correctly match the RemoteControl(TV tv) constructor
        RemoteControl remote = new RemoteControl(tv);

        System.out.println("--- Traditional Approach Execution ---");
        remote.pressOnButton();
        remote.pressChannelButton(5);
        remote.pressVolumeButton(20);
        remote.pressOnChangeVolumeAndChannelButton(25, 8);
        remote.pressOffButton();
    }
}