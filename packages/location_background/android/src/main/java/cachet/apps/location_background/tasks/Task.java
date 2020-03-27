package cachet.apps.location_background.tasks;

import cachet.apps.location_background.OnCompletionListener;

import java.util.UUID;

public abstract class Task<TOptions> {
    private final UUID mTaskID;
    private final TaskContext<TOptions> mTaskContext;

    Task(TaskContext<TOptions> context) {
        mTaskID = UUID.randomUUID();
        mTaskContext = context;
    }

    public UUID getTaskID() {
        return mTaskID;
    }

    TaskContext<TOptions> getTaskContext() {
        return mTaskContext;
    }

    public abstract void startTask();

    public void stopTask() {
        OnCompletionListener completionListener = getTaskContext().getCompletionListener();

        if(completionListener != null) {
            completionListener.onCompletion(getTaskID());
        }
    }
}
