package core.drivers;

import java.util.ArrayList;

import static sun.misc.ThreadGroupUtils.getRootThreadGroup;

/**
 * Driver killer is a thread, who will live with browser instance and kill browser after end of tests.
 * It starts when create new driver.
 */

class DriverKiller extends Thread {

    private Long threadId;
    private ArrayList<Long> aliveThreads = getAliveThreads();


    public DriverKiller(Long threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        super.run();
        while (!this.isInterrupted()) {
            killUnusedBrowser(threadId);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                currentThread().interrupt();
                break;
            }
        }
    }

    /**
     * Get all alive threads in current time
     * @return ArrayList with all threads
     */
    private ArrayList<Long> getAliveThreads() {
        ArrayList<Long> aThreads = new ArrayList<>();
        ThreadGroup threadGroup = getRootThreadGroup();
        int allActiveThreads = threadGroup.activeCount();
        Thread[] allThreads = new Thread[allActiveThreads];
        threadGroup.enumerate(allThreads);
        for (int i = 0; i < allThreads.length; i++) {
            Thread thread = allThreads[i];
            if (thread != null) aThreads.add(thread.getId());
        }
        return aThreads;
    }

    /**
     * Method kill unused browser by threadId
     * @param threadId
     */
    private void killUnusedBrowser(Long threadId) {
        aliveThreads = getAliveThreads();
        if (!aliveThreads.contains(threadId)) {
            SelenideDriverStorage.closeDriver(threadId);
        }
    }
}
