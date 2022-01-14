from tensorflow.keras.layers import Activation, Conv2D, BatchNormalization, Dense, Dropout, Flatten, MaxPooling2D
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.models import Sequential
import numpy as np
import cv2
from classification_emotions import Classifictions;
from model import Model;


class ImageDetection():

    def get_img_classified(img_path):

        if img_path is not  '':
            img = cv2.imread(img_path)
            Classifictions.get_expression_classified(img, model)
            cv2.imshow('img', img)
            while True:
                k = cv2.waitKey(0)
                if k==27:    # Esc key to stop
                    cv2.destroyAllWindows()
                break
        else: print("No image selected!")


if __name__ == '__main__':

    model = Model.create_model()
    model.load_weights('./src/model_2022-01-08.h5')

