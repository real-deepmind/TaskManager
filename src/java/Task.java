public class Task {
    private String description;
    private int timeOffer;
    public Task(String description, int timeOffer) throws InvalidTaskException {
        if (description == null || description.trim().isEmpty()) {
            throw new InvalidTaskException("Description cannot be null or empty");
        }
        if (timeOffer <= 0) {
            throw new InvalidTaskException("Time offer cannot be negative");
        }
        this.description = description;
        this.timeOffer = timeOffer;
    }
    //get time
    public String getDescription() {
        return description;
    }
    //set time
    public void setDescription(String description) throws InvalidTaskException  {
        if (description == null || description.trim().isEmpty()) {
            throw new InvalidTaskException("Description cannot be null or empty");
        }
        this.description = description;

    }
    //get time
    public int getTimeOffer() {
        return timeOffer;
    }
    //set time
    public void setTimeOffer(int timeOffer) throws InvalidTaskException {
        if (timeOffer <= 0) {
            throw new InvalidTaskException("Time offer cannot be negative");
        }
        this.timeOffer = timeOffer;
    }
    @Override
    public String toString() {
        return "task: " + description + ", time offer: " + timeOffer;
    }


}
