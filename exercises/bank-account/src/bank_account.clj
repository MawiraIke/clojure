(ns bank-account)

(def acct (atom {:name "" :balance 0}))

(def acc (atom nil))

(defn open-account []
  (reset! acc acct))

(defn close-account [account]
  (reset! account account))

(defn get-balance [account]
  (get @account :balance))

(defn update-balance [account sum]
  (reset! account (assoc @account :balance (+ (get-balance account) sum))))
