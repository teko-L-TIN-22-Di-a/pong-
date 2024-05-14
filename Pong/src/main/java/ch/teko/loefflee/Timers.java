package src.main.java.ch.teko.loefflee;

import java.util.Timer;
import java.util.TimerTask;

public class Timers {
    private SpecialEffects specialEffects;
    private Timer effectTimer;
    private Timer resetTimer;

    public Timers(SpecialEffects specialEffects) {
        this.specialEffects = specialEffects;
        this.resetTimer = new Timer(); // Initialisieren Sie resetTimer hier
    }

    public void startEffectTimer() {
        effectTimer = new Timer();
        effectTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                specialEffects.activateRandomEffect(); // Aktiviere einen zufälligen Effekt
                startResetTimer(); // Starte den Reset-Timer nach 10 Sekunden
            }
        }, 0, 15000); // Starte sofort, wiederhole alle 15 Sekunden
    }

    public void startResetTimer() {
        resetTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                specialEffects.resetEffect(); // Zurücksetzen des Effekts nach 5 Sekunden
            }
        }, 10000); // Starte nach 10 Sekunden
    }
}
