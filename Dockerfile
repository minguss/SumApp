FROM websphere-liberty:webProfile7

ADD target/sumapp.war /config/dropins/

EXPOSE 9080

ENV LICENSE accept
