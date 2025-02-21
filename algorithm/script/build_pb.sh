#!/bin/bash
SRC_DIR="."
JAVA_DST_DIR="../src/main/java"
PYTHON_DST_DIR="../src/main/python"

./protoc-29.3-win64/bin/protoc -I=$SRC_DIR --java_out=$JAVA_DST_DIR $SRC_DIR/video_info.proto
./protoc-29.3-win64/bin/protoc -I=$SRC_DIR --python_out=$PYTHON_DST_DIR $SRC_DIR/video_info.proto