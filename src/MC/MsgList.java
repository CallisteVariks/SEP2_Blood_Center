package MC;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ghost on 12/12/2016.
 */
public class MsgList implements Serializable {
    private ArrayList<RequestMsg> requestMsgs;

    private ArrayList<Notifications> notificationMsgs;

    /**
     * No argument constructor
     * Initializes the ArrayList
     */
    public MsgList() {
        requestMsgs = new ArrayList<>();
        notificationMsgs = new ArrayList<>();
    }

    /**
     * Adds a msg element to the arrayList
     *
     * @param msg type RequestMsg
     */
    public void addRequestMsg(RequestMsg msg) {
        requestMsgs.add(msg);
    }

    /**
     * @param index int
     * @return list with msg at index
     */
    public RequestMsg getMsg(int index) {
        return requestMsgs.get(index);
    }

    /**
     * gets allRequestedMsgs
     *
     * @return list with AllRequestedMsgs
     */
    public MsgList getAllRequestMsgs() {
        MsgList list = new MsgList();

        for (RequestMsg msg : this.requestMsgs)
            list.addRequestMsg(msg);
        return list;
    }

    /**
     * Adds a msg element to the arrayList
     *
     * @param msg type Notifications
     */
    public void addMsg(Notifications msg) {
        notificationMsgs.add(msg);
    }

    /**
     * @param index int
     * @return list with notificationMsg at index
     */
    public Notifications getNotificationMsg(int index) {
        return notificationMsgs.get(index);
    }

    /**
     * gets allNotificationMsgs
     *
     * @return list with allNotificationMsgs
     */
    public MsgList getAllNotificationMsgs() {
        MsgList list = new MsgList();

        for (Notifications msg : notificationMsgs)
            list.addMsg(msg);
        return list;
    }

    /**
     * gets rqCount
     *
     * @return int size
     */
    public int rqCount() {
        return requestMsgs.size();
    }

    /**
     * gets ntCount
     *
     * @return int size
     */
    public int ntCount() {
        return notificationMsgs.size();
    }

}
