# Facail Expression Recognition Application

**Minghan Li** (viclmh@umich.edu), **Hongju Lee** (hongjlee@umich.edu)

## Project Description
This is a mastery capstone project for SI699 at University of Michigan - Ann Arbor.

In this project, we designed and created a facial expression recognition web application supporting classifying 4 kinds of different expressions: **1. Neutral 2.Happy 3.Sad 4.Surprise** and showing corresponding emojis.

We have deployed the frontend into AWS Amplify and deployed the backend into GCP Google App Engine. Therefore, you could visit our deployed website at instead of running this locally because you may spend some time on the backend java environment configuration. 

## Frontend
Frontend development is implemented by Javascript and using React.js. The full library and dependencies are listed in package.json.

### Installation
If you would like to run the frontend locally. Follow these steps:

`git clone https://github.com/viclmh/Capstone_FacialExpRecog.git`

`cd frontend/`

`npm install`

`npm start`

You will then see a pop-up website hosting on your browser with url `localhost:3000`

## Backend
The backend part is implemented by using Java and Springboot Framework. The required dependencies for running backend is listed in the pom.xml.

### Environment Setup
- OS: macOS Big Sur 11.6.5 (Intel Chip)
- IDE: IntelliJ 2021.3.2
- SDK: Oracle OpenJDK version 18.0.2
- Language Level: Java 17

After finishing the environment setup, you could start your IntelliJ and open the backend/ folder. Run the maven reload, maven clean and maven install under the Maven toolbar on the right side of the screen. Click on the start buttion to run the backend on `localhost:8080`. Then you could send the request from frontend and get a classification result. 

## Data science & Machine Learning

## Dataset
In this project, we used the AffectNet database owned by Professor Mohammad H. Mahoor from University of Denver. For the machine learning model training, we used the AffectNet8 dataset with eight (8) labels: A mini version (around 4GB) that only contains the manually annotated images with 8 labels (0-7 as explained above) released since March 2021.
- **Citation:** A. Mollahosseini; B. Hasani; M. H. Mahoor, "AffectNet: A Database for Facial Expression, Valence, and Arousal Computing in the Wild," in IEEE Transactions on Affective Computing, 2017.

  
