package com.CustomCourseCreator.Util;


public class YouTubeUtil {
    public static String extractVideoId(String url) {
        // Find the position of 'v=' in the URL
        int videoIdStart = url.indexOf("v=") + 2;
        // The video ID is typically 11 characters long
        int videoIdEnd = videoIdStart + 11;

        // Extract the video ID using substring
        String videoId = url.substring(videoIdStart, Math.min(videoIdEnd, url.length()));

        // Ensure the extracted video ID is valid
        int ampersandPosition = videoId.indexOf('&');
        if (ampersandPosition != -1) {
            videoId = videoId.substring(0, ampersandPosition);
        }

        return videoId;
    }
}
