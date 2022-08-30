# ExoPlayerStats

ExoPlayerStats is an open source sdk for counting ExoPlayer playback status.

ExoPlayerStats allows you to collect information such as player stuttering, first frame rendering time, stream switching, and playback errors.

## Using ExoPlayerStats


In the demo project, I demonstrated the use of the ExoPlayerStats library.

Currently, ExoPlayerStats has only been adapted and tested for ExoPlayer 2.17.1.

Here are the key steps to use the ExoPlayerStats library.

**1. Add ExoPlayerStats module dependencies**

```groovy
implementation 'io.github.agoralab:ExoPlayerStats:1.0.0'
```


**2. Add code to use statistics library**

First, import ExoPlayerAgoraStats libaray.
```java
import com.agora.stats.ExoPlayerAgoraStats;
```

Then, create an ExoPlayerAgoraStats object with appid and environment token params. 
In the meantime, you should pass an ExoPlayer object(player variable in the code below) to ExoPlayerAgoraStats object.

```java
/*
 * Set the callback function of log output. You can set it accroding to your needing.
 */
ExoPlayerAgoraStats.setLogCallback((String type, String tag, String message)->{
if("debug" == type){
    Log.d(tag, message);
}
else if("error" == type){
    Log.e(tag, message);
}
});

/*
 * There are two key params should be passed to ExoPlayerAgoraStats object by CustomerConfigData object.
 * 
 * APP_ID_FROM_AGORA_PROJECT is a string, you can get it from https://console.agora.io/projects page.
 * This page will request you login, This is a necessary step. 
 * After login, goto https://console.agora.io/projects page again.
 * If you don`t have any project, please creating one.After the step, you will see the App ID of project.
 * 
 * ENVIRONMENT_TOKEN_FROM_AGORA is a string, you can get it from agora staff.
 */
CustomerConfigData customerConfigData = new CustomerConfigData();
customerConfigData.setAppID(APP_ID_FROM_AGORA_PROJECT);
customerConfigData.setEnvironmentToken(ENVIRONMENT_TOKEN_FROM_AGORA);
exoPlayerAgoraStats = new ExoPlayerAgoraStats(player, "exoplayer_agora", customerConfigData);
```

At last, you should release ExoPlayerAgoraStats object before ExoPlayer object release.
```java
if(null != exoPlayerAgoraStats){
    exoPlayerAgoraStats.release();
    exoPlayerAgoraStats = null;
}
```


More detail of code implementation please check demo/src/main/java/com/google/android/exoplayer2/demo/PlayerActivity.java source file.

**3. Looking up statistics data**

If you want to view statistics data of ExoPlayer, please contact with agora staff.


