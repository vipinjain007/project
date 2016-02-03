package com.mediaocean.rest.responseUtil;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.Serializable;

/**
 * Created by mediaocean on 01-02-2016.
 */
public class ResponseObj<T> implements Serializable {

    private Status _status = Status.UNKNOWN;
    private Object _result = null;
    private int _count = -1;
    private Logger _log = LoggerFactory.getLogger(ResponseObj.class);




    public Status getStatus() {
        return _status;
    }

    public void setStatus(Status value) {
        _status = value;
    }

    public void set(Exception ex) throws Exception
    {
        _log.error(ex.toString());

        this.setStatus(Status.FAILURE);
        this.setResult(ex.getMessage());

        // the new philosophy is that we don't want to return a Success = false
        // they would prefer to see a 4XX or 5XX HTTP error instead
        // TODO: make sure the return status and message are what they want
        throw new  Exception(ex);
    }

    public void set(Object entity) throws Exception
    {
        this.setStatus(Status.SUCCESS);
        this.setResult(entity);
    }


    public Object getResult() {
        return _result;
    }

    public void setResult(Object value) {
        _result = value;
    }

    public int getCount() {

        int result = _count;


        // this was added to check in case result was set, but count was not
        if (_count == -1)
        {
            if (_result == null) {
                // default to a count of zero
                result = 0;
            }
            else {
                // otherwise, see what the object type is and retrieve the count of results in the object / container
                if (_result instanceof java.awt.List) {
                    result = ((java.awt.List) _result).getItemCount();
                } else if (_result instanceof java.util.ArrayList) {
                    result = ((java.util.ArrayList) _result).size();
                } else if (_result instanceof java.lang.Object[]) {
                    result = ((java.lang.Object[]) _result).length;
                } else if (_result instanceof com.mediaocean.rest.responseUtil.ListResult) {
                    result = ((com.mediaocean.rest.responseUtil.ListResult) _result).getCount();
                } else {
                    // assume it is a single primitive or entity object
                    result = 1;
                }
            }
        }

        return result;
    }

    public void setCount(int value) {
        _count = value;
    }

   
}
