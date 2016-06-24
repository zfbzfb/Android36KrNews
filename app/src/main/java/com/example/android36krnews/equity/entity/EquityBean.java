package com.example.android36krnews.equity.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2016/6/21 0021.
 */
public class EquityBean {

    private int code;

    private DataBean data;

    public static EquityBean getObjectFromData(String json){
        return new Gson().fromJson(json,EquityBean.class);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int total;
        private int per_page;
        private int current_page;
        private int last_page;
        private String next_page_url;
        private Object prev_page_url;
        private int from;
        private int to;
        /**
         * id : 180
         * financing_type : 1
         * fund_raising : 15000000
         * valuation : 120000000
         * cf_raising : 14000000
         * cf_success_raising : 11860000
         * cf_success_raising_offer : 11910000
         * cf_min_raising : 12000000
         * cf_max_raising : 15000000
         * round : 30
         * company_id : 154573
         * lead_user_id : 1158053370
         * min_investment : 50000
         * max_coinvestor_number : 98
         * lead_org_id : 0
         * manager_id : 1158053370
         * sort_num : 52
         * hot : 1
         * status : 30
         * can_exit : 0
         * start_time : 05/27/2016 10:00:00
         * end_time : 06/26/2016 10:00:00
         * leader : {"id":1158053370,"name":"海鼎资本","avatar":"https://pic.36krcnd.com/avatar/201605/17132607/yb3hrj3u7h9638ng.jpg!480","intro":"关注健康领域的互联网+"}
         * organization : null
         * company : {"id":154573,"name":"华佗驾到（潼诚一得）","logo":"https://krplus-pic.b0.upaiyun.com/201512/01045835/5umei1tvdivd9ohk.png","manager_id":63129,"brief":"健康行业领先的SaaS服务平台","industry":10,"company_industry":{"id":10,"name":"医疗健康","enum_name":"MEDICAL_HEALTH"}}
         * desc : {"cf_id":180,"file_list_img":"https://krplus-pic.b0.upaiyun.com/201605/17/51e6a0f91d4ee855f8e6777be5e39e8f.png","cf_advantage":[{"label":"创始人","value":"管理经验和资源优势强"},{"label":"团队成员","value":"线上+线下完美结合"}]}
         * has_reminder : false
         * investor_count : 91
         * sell_shares : 11.11%
         */

        private List<Data2Bean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public String getNext_page_url() {
            return next_page_url;
        }

        public void setNext_page_url(String next_page_url) {
            this.next_page_url = next_page_url;
        }

        public Object getPrev_page_url() {
            return prev_page_url;
        }

        public void setPrev_page_url(Object prev_page_url) {
            this.prev_page_url = prev_page_url;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public List<Data2Bean> getData() {
            return data;
        }

        public void setData(List<Data2Bean> data) {
            this.data = data;
        }

        public static class Data2Bean {
            private int id;
            private int financing_type;
            private int fund_raising;
            private int valuation;
            private int cf_raising;
            private int cf_success_raising;
            private int cf_success_raising_offer;
            private int cf_min_raising;
            private int cf_max_raising;
            private String round;
            private int company_id;
            private int lead_user_id;
            private int min_investment;
            private int max_coinvestor_number;
            private int lead_org_id;
            private int manager_id;
            private int sort_num;
            private int hot;
            private int status;
            private int can_exit;
            private String start_time;
            private String end_time;
            /**
             * id : 1158053370
             * name : 海鼎资本
             * avatar : https://pic.36krcnd.com/avatar/201605/17132607/yb3hrj3u7h9638ng.jpg!480
             * intro : 关注健康领域的互联网+
             */

            private LeaderBean leader;
            private OrganizationBean organization;
            /**
             * id : 154573
             * name : 华佗驾到（潼诚一得）
             * logo : https://krplus-pic.b0.upaiyun.com/201512/01045835/5umei1tvdivd9ohk.png
             * manager_id : 63129
             * brief : 健康行业领先的SaaS服务平台
             * industry : 10
             * company_industry : {"id":10,"name":"医疗健康","enum_name":"MEDICAL_HEALTH"}
             */

            private CompanyBean company;
            /**
             * cf_id : 180
             * file_list_img : https://krplus-pic.b0.upaiyun.com/201605/17/51e6a0f91d4ee855f8e6777be5e39e8f.png
             * cf_advantage : [{"label":"创始人","value":"管理经验和资源优势强"},{"label":"团队成员","value":"线上+线下完美结合"}]
             */

            private DescBean desc;
            private boolean has_reminder;
            private int investor_count;
            private String sell_shares;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getFinancing_type() {
                return financing_type;
            }

            public void setFinancing_type(int financing_type) {
                this.financing_type = financing_type;
            }

            public int getFund_raising() {
                return fund_raising;
            }

            public void setFund_raising(int fund_raising) {
                this.fund_raising = fund_raising;
            }

            public int getValuation() {
                return valuation;
            }

            public void setValuation(int valuation) {
                this.valuation = valuation;
            }

            public int getCf_raising() {
                return cf_raising;
            }

            public void setCf_raising(int cf_raising) {
                this.cf_raising = cf_raising;
            }

            public int getCf_success_raising() {
                return cf_success_raising;
            }

            public void setCf_success_raising(int cf_success_raising) {
                this.cf_success_raising = cf_success_raising;
            }

            public int getCf_success_raising_offer() {
                return cf_success_raising_offer;
            }

            public void setCf_success_raising_offer(int cf_success_raising_offer) {
                this.cf_success_raising_offer = cf_success_raising_offer;
            }

            public int getCf_min_raising() {
                return cf_min_raising;
            }

            public void setCf_min_raising(int cf_min_raising) {
                this.cf_min_raising = cf_min_raising;
            }

            public int getCf_max_raising() {
                return cf_max_raising;
            }

            public void setCf_max_raising(int cf_max_raising) {
                this.cf_max_raising = cf_max_raising;
            }

            public String getRound() {
                return round;
            }

            public void setRound(String round) {
                this.round = round;
            }

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getLead_user_id() {
                return lead_user_id;
            }

            public void setLead_user_id(int lead_user_id) {
                this.lead_user_id = lead_user_id;
            }

            public int getMin_investment() {
                return min_investment;
            }

            public void setMin_investment(int min_investment) {
                this.min_investment = min_investment;
            }

            public int getMax_coinvestor_number() {
                return max_coinvestor_number;
            }

            public void setMax_coinvestor_number(int max_coinvestor_number) {
                this.max_coinvestor_number = max_coinvestor_number;
            }

            public int getLead_org_id() {
                return lead_org_id;
            }

            public void setLead_org_id(int lead_org_id) {
                this.lead_org_id = lead_org_id;
            }

            public int getManager_id() {
                return manager_id;
            }

            public void setManager_id(int manager_id) {
                this.manager_id = manager_id;
            }

            public int getSort_num() {
                return sort_num;
            }

            public void setSort_num(int sort_num) {
                this.sort_num = sort_num;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCan_exit() {
                return can_exit;
            }

            public void setCan_exit(int can_exit) {
                this.can_exit = can_exit;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public LeaderBean getLeader() {
                return leader;
            }

            public void setLeader(LeaderBean leader) {
                this.leader = leader;
            }

            public OrganizationBean getOrganization() {
                return organization;
            }

            public void setOrganization(OrganizationBean organization) {
                this.organization = organization;
            }

            public CompanyBean getCompany() {
                return company;
            }

            public void setCompany(CompanyBean company) {
                this.company = company;
            }

            public DescBean getDesc() {
                return desc;
            }

            public void setDesc(DescBean desc) {
                this.desc = desc;
            }

            public boolean isHas_reminder() {
                return has_reminder;
            }

            public void setHas_reminder(boolean has_reminder) {
                this.has_reminder = has_reminder;
            }

            public int getInvestor_count() {
                return investor_count;
            }

            public void setInvestor_count(int investor_count) {
                this.investor_count = investor_count;
            }

            public String getSell_shares() {
                return sell_shares;
            }

            public void setSell_shares(String sell_shares) {
                this.sell_shares = sell_shares;
            }

            public static class LeaderBean {
                private int id;
                private String name;
                private String avatar;
                private String intro;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }
            }
            public static class OrganizationBean {
                private int id;
                private String name;
                private String logo;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

            }

            public static class CompanyBean {
                private int id;
                private String name;
                private String logo;
                private int manager_id;
                private String brief;
                private int industry;
                /**
                 * id : 10
                 * name : 医疗健康
                 * enum_name : MEDICAL_HEALTH
                 */

                private CompanyIndustryBean company_industry;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public int getManager_id() {
                    return manager_id;
                }

                public void setManager_id(int manager_id) {
                    this.manager_id = manager_id;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public int getIndustry() {
                    return industry;
                }

                public void setIndustry(int industry) {
                    this.industry = industry;
                }

                public CompanyIndustryBean getCompany_industry() {
                    return company_industry;
                }

                public void setCompany_industry(CompanyIndustryBean company_industry) {
                    this.company_industry = company_industry;
                }

                public static class CompanyIndustryBean {
                    private int id;
                    private String name;
                    private String enum_name;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getEnum_name() {
                        return enum_name;
                    }

                    public void setEnum_name(String enum_name) {
                        this.enum_name = enum_name;
                    }
                }
            }

            public static class DescBean {
                private int cf_id;
                private String file_list_img;
                /**
                 * label : 创始人
                 * value : 管理经验和资源优势强
                 */

                private List<CfAdvantageBean> cf_advantage;

                public int getCf_id() {
                    return cf_id;
                }

                public void setCf_id(int cf_id) {
                    this.cf_id = cf_id;
                }

                public String getFile_list_img() {
                    return file_list_img;
                }

                public void setFile_list_img(String file_list_img) {
                    this.file_list_img = file_list_img;
                }

                public List<CfAdvantageBean> getCf_advantage() {
                    return cf_advantage;
                }

                public void setCf_advantage(List<CfAdvantageBean> cf_advantage) {
                    this.cf_advantage = cf_advantage;
                }

                public static class CfAdvantageBean {
                    private String label;
                    private String value;

                    public String getLabel() {
                        return label;
                    }

                    public void setLabel(String label) {
                        this.label = label;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }
            }
        }
    }
}
