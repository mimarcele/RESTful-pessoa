package com.codigolimpo.api.exception.details;

import lombok.Data;

@Data
public class PessoaNotFoundDetails {
    private String title;
    private int status;
    private String details;
    private long timestamp;


    public static final class PessoaNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private long timestamp;

        private PessoaNotFoundDetailsBuilder() {
        }

        public static PessoaNotFoundDetailsBuilder newBuilder() {
            return new PessoaNotFoundDetailsBuilder();
        }

        public PessoaNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PessoaNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public PessoaNotFoundDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public PessoaNotFoundDetailsBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public PessoaNotFoundDetails build() {
            PessoaNotFoundDetails pessoaNotFoundDetails = new PessoaNotFoundDetails();
            pessoaNotFoundDetails.setTitle(title);
            pessoaNotFoundDetails.setStatus(status);
            pessoaNotFoundDetails.setDetails(details);
            pessoaNotFoundDetails.setTimestamp(timestamp);
            return pessoaNotFoundDetails;
        }
    }
}
