from tensorflow.keras.layers import Activation, Conv2D, BatchNormalization, Dense, Dropout, Flatten, MaxPooling2D
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.models import Sequential
import numpy as np
import cv2


cv2.ocl.setUseOpenCL(False)
face_cascade = cv2.CascadeClassifier(
cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')


class Classifictions():
    
    def get_expression_classified(img, model):

        expression_types = {0: "Angry", 1: "Disgusted", 2: "Fearful",
                            3: "Happy", 4: "Neutral", 5: "Sad", 6: "Surprised"}

        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        faces = face_cascade.detectMultiScale(
            gray, scaleFactor=1.3, minNeighbors=5)

        for (x, y, w, h) in faces:
            cv2.rectangle(img, (x, y-50), (x+w, y+h+20), (255, 0, 0), 2)
            roi_gray = gray[(y-10):y+h+10, (x-10):x+w+10]
            cropped_img = np.expand_dims(np.expand_dims(
                cv2.resize(roi_gray, (48, 48)), -1), 0)
            print(cropped_img)
            prediction = model.predict(cropped_img)
            maxindex = int(np.argmax(prediction))
            cv2.putText(
                img,
                expression_types[maxindex],
                (x+20, y-60),
                cv2.FONT_HERSHEY_SIMPLEX,
                1,
                (0, 255, 0),
                2,
                cv2.LINE_AA
            )

        pass