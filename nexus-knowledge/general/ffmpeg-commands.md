# ffmpeg-commands

FFmpeg: ffmpeg -i input.mp4 -vf scale=1280:720 -c:v libx264 -crf 23 output.mp4. Transcode, trim (-ss, -t), concat, add subtitles (-vf subtitles), extract audio (-vn).
