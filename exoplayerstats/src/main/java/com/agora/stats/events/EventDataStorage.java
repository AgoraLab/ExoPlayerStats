package com.agora.stats.events;

import com.agora.stats.common.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


public class EventDataStorage {

  public static final String TAG = "EventDataStorage";

  protected JSONObject dataStorage;

  public EventDataStorage(){
    this.dataStorage = new JSONObject();
  }

  public JSONArray keys() {
    if (this.dataStorage.names() == null) {
      return new JSONArray();
    }
    return this.dataStorage.names();
  }

  public void put(final String key, final String value)  {
    try{
      this.dataStorage.put(key, (Object)value);
    }
    catch (JSONException exception){
      Logger.e(TAG, "put data fail, key:" + key + " value:" + value);
    }

  }

  public void put(final String key, final int value) {
    try{
      this.dataStorage.put(key, value);
    }
    catch (JSONException exception){
      Logger.e(TAG, "put data fail, key:" + key + " value:" + value);
    }

  }

  public void put(final String key, final long value) {
    try{
      this.dataStorage.put(key, value);
    }
    catch (JSONException exception){
      Logger.e(TAG, "put data fail, key:" + key + " value:" + value);
    }
  }

  public void remove(final String key) {
    this.dataStorage.remove(key);
  }

  public String getString(String key) {
    if (!this.dataStorage.has(key)) {
      return null;
    }

    try {
      key = this.dataStorage.getString(key);
      if (key.isEmpty()){
        key = null;
      }
    }
    catch (Exception exception){
      Logger.e(TAG, "get string value fail, key:" + key);
      key = null;
    }

    return key;
  }

  public int getInt(String key) {
    try {
      return this.dataStorage.getInt(key);
    }
    catch (Exception exception){
      Logger.e(TAG, "get int value fail, key:" + key);
    }

    return 0;
  }

  public long getLong(String key){
    try {
      return this.dataStorage.getLong(key);
    }
    catch (Exception exception){
      Logger.e(TAG, "get long value fail, key:" + key);
    }

    return 0;
  }


  public String toString(){
    return this.dataStorage.toString();
  }

  public void clear() {
    this.dataStorage = new JSONObject();
  }

}
