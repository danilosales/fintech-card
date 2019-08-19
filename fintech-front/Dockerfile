#########################
### build environment ###
#########################

# base image
FROM node:10.16.3 as builder

# set working directory
WORKDIR /usr/src/app

# install and cache app dependencies
COPY package*.json ./


RUN npm install

# add app
COPY . .

# generate build
RUN npm run build

##################
### production ###
##################

# base image
FROM nginx:1.15.7-alpine

# copy artifact build from the 'build environment'
COPY --from=builder /usr/src/app/dist/fintech-front /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
