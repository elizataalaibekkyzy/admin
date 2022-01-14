import tkinter as tk;
from PIL import Image, ImageTk
from tensorflow.keras.layers import Activation, Conv2D, BatchNormalization, Dense, Dropout, Flatten, MaxPooling2D
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.models import Sequential
import numpy as np
import cv2
from classification_emotions import Classifictions;
from model import Model;

model = Model.create_model()
model.load_weights('./src/model_2022-01-08.h5')

class LiveDetection():

    def live_face_expression(display):
        cap = cv2.VideoCapture(0)
        
        while True:
            ret, frame = cap.read()
            frame = cv2.flip(frame, 1)
            cv2image = cv2.cvtColor(frame, cv2.COLOR_BGR2RGBA)
            img = Image.fromarray(cv2image)
            imgtk = ImageTk.PhotoImage(image=img)
            display.imgtk = imgtk
            display.configure(image=imgtk)

            if not ret:
                break
            
            Classifictions.get_expression_classified(img, model)
            cv2.imshow('Video', cv2.resize(
            img, (1600, 960), interpolation=cv2.INTER_CUBIC))

            k = cv2.waitKey(33)
            if k==27:    # Esc key to stop
                break
        
        cap.release()
        cv2.destroyAllWindows()
                
    