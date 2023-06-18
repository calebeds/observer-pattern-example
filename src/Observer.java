public interface Observer {
    // method to update the observer, used by subject
    public void update();

    // attach with subject to observe, no required, but, added so that the
    // the observer can query the subject to see if an upadte has ocurred
    public void setSubject(Subject subject);
}