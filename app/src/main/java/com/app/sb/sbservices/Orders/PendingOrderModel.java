package com.app.sb.sbservices.Orders;

public class PendingOrderModel {



        private String orderProductId;
        private String orderId;
        private String serviceId;
        private String subServiceId;
        private String packageId;
        private Object subPackageId;
        private String price;
        private String qty;
        private String timeSlot;
        private String serviceDate;

        public String getOrderProductId() {
            return orderProductId;
        }

        public void setOrderProductId(String orderProductId) {
            this.orderProductId = orderProductId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getSubServiceId() {
            return subServiceId;
        }

        public void setSubServiceId(String subServiceId) {
            this.subServiceId = subServiceId;
        }

        public String getPackageId() {
            return packageId;
        }

        public void setPackageId(String packageId) {
            this.packageId = packageId;
        }

        public Object getSubPackageId() {
            return subPackageId;
        }

        public void setSubPackageId(Object subPackageId) {
            this.subPackageId = subPackageId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getTimeSlot() {
            return timeSlot;
        }

        public void setTimeSlot(String timeSlot) {
            this.timeSlot = timeSlot;
        }

        public String getServiceDate() {
            return serviceDate;
        }

        public void setServiceDate(String serviceDate) {
            this.serviceDate = serviceDate;
        }
    }

