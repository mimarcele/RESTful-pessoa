package com.codigolimpo.exception.details;

import lombok.Data;

@Data
public class EnderecoNotFoundDetails {
    private String title;
    private int status;
    private String details;
    private long timestamp;

    public static final class EnderecoNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private long timestamp;


        private EnderecoNotFoundDetailsBuilder() {
        }

        public static EnderecoNotFoundDetailsBuilder newBuilder() {
            return new EnderecoNotFoundDetailsBuilder();
        }

        public EnderecoNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public EnderecoNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public EnderecoNotFoundDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public EnderecoNotFoundDetailsBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public EnderecoNotFoundDetails build() {
            EnderecoNotFoundDetails enderecoNotFoundDetails = new EnderecoNotFoundDetails();
            enderecoNotFoundDetails.setTitle(title);
            enderecoNotFoundDetails.setStatus(status);
            enderecoNotFoundDetails.setDetails(details);
            enderecoNotFoundDetails.setTimestamp(timestamp);
            return enderecoNotFoundDetails;
        }
    }
}
