from tensorflow.keras.layers import Activation, Conv2D, BatchNormalization, Dense, Dropout, Flatten, MaxPooling2D
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.models import Sequential
import numpy as np
import cv2

cv2.ocl.setUseOpenCL(False)
face_cascade = cv2.CascadeClassifier(
    cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')


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


def get_img_classified(model, path):
    img = cv2.imread(path)
    get_expression_classified(img, model)
    cv2.imshow('img', img)
    while True:
        k = cv2.waitKey(0)
        if k==27:    # Esc key to stop
            cv2.destroyAllWindows()
        break


def live_face_expression(model):
    cap = cv2.VideoCapture(0)
    while True:
        ret, img = cap.read()
        if not ret:
            break
        
        get_expression_classified(img, model)

        cv2.imshow('Video', cv2.resize(
        img, (1600, 960), interpolation=cv2.INTER_CUBIC))

        k = cv2.waitKey(33)
        if k==27:    # Esc key to stop
            break
    cap.release()
    cv2.destroyAllWindows()


def create_model():
    model = Sequential()
    X_shape = (48, 48, 1)

    model.add(Conv2D(64, (3, 3), input_shape=X_shape))
    model.add(Activation('relu'))
    model.add(MaxPooling2D(pool_size=(2, 2)))
    model.add(Dropout(0.25))

    model.add(Conv2D(128, (5, 5)))
    model.add(Activation('relu'))
    model.add(MaxPooling2D(pool_size=(2, 2)))
    model.add(Dropout(0.25))

    model.add(Flatten())

    model.add(Dense(256))
    model.add(BatchNormalization())
    model.add(Activation('relu'))
    model.add(Dropout(0.25))

    model.add(Dense(512))
    model.add(BatchNormalization())
    model.add(Activation('relu'))
    model.add(Dropout(0.25))

    number_possible_outputs = 7
    model.add(Dense(number_possible_outputs))

    model.add(Activation('softmax'))

    opt = Adam(learning_rate=0.00005)
    model.compile(optimizer=opt, loss='categorical_crossentropy',
                  metrics=['accuracy'])
    model.summary()

    return model


model = create_model()
model.load_weights('./model_2022-01-08.h5')

#live_face_expression(model)

get_img_classified(model, '/Users/admin/Desktop/slide_1.jpeg')
